package ru.job4j.cinema.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Ticket;

import java.util.Optional;

/**
 * Класс реализует интерфейс TicketRepository
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 26.03.2023
 */

@Repository
public class Sql2oTicketRepository implements TicketRepository {

    private static final Logger LOG = LoggerFactory.getLogger(Sql2oTicketRepository.class);

    private final Sql2o sql2o;

    public Sql2oTicketRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Ticket> save(Ticket ticket) {
        try (var connection = sql2o.open()) {
            var sql = """
                    INSERT INTO tickets (session_id, row_number, place_number, user_id)
                    VALUES (:sessionId, :rowNumber, :placeNumber, :userId)
                    """;
            var query = connection.createQuery(sql, true)
                    .addParameter("sessionId", ticket.getSessionId())
                    .addParameter("rowNumber", ticket.getRowNumber())
                    .addParameter("placeNumber", ticket.getPlaceNumber())
                    .addParameter("userId", ticket.getUserId());
            int generatedId = query.executeUpdate().getKey(Integer.class);
            ticket.setId(generatedId);
            return Optional.of(ticket);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Ticket> findBySessionIdRowNumberPlaceNumber(int sessionId, int rowNumber, int placeNumber) {
        try (var connection = sql2o.open()) {
            var sql = """
                    SELECT * FROM tickets
                    WHERE session_id = :sessionId AND row_number = :rowNumber AND place_number = :placeNumber
                    """;
            var query = connection.createQuery(sql);
            query.addParameter("sessionId", sessionId)
                    .addParameter("rowNumber", rowNumber)
                    .addParameter("placeNumber", placeNumber);
            var ticket = query.setColumnMappings(Ticket.COLUMN_MAPPING).executeAndFetchFirst(Ticket.class);
            return Optional.ofNullable(ticket);
        }
    }
}
