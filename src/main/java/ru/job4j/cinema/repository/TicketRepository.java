package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Ticket;

import java.util.Optional;

/**
 * Интерфейс инкапсулирующий логику хранения данных
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 26.03.2023
 */
public interface TicketRepository {
    Optional<Ticket> save(Ticket ticket);

    Optional<Ticket> findBySessionIdRowNumberPlaceNumber(int sessionId, int row, int place);
}
