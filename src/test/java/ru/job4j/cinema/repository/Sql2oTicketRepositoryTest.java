package ru.job4j.cinema.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import ru.job4j.cinema.configuration.DatasourceConfiguration;
import ru.job4j.cinema.model.Ticket;

import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Класс тестирует методы класса Sql2oTicketRepository
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 10.04.2023
 */
class Sql2oTicketRepositoryTest {

    private static Sql2oTicketRepository sql2oTicketRepository;

    private static Sql2o sql2o;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oTicketRepositoryTest.class
                .getClassLoader()
                .getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");

        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        sql2o = configuration.databaseClient(datasource);

        sql2oTicketRepository = new Sql2oTicketRepository(sql2o);
    }

    @AfterEach
    public void clearTickets() {
        try (Connection connection = sql2o.open()) {
            connection.createQuery("DELETE FROM tickets")
                    .executeUpdate();
        }
    }

    @Test
    public void whenSaveThenGetSame() {
        var ticket = sql2oTicketRepository.save(new Ticket(1, 5, 7, 1)).get();
        var savedTicket = sql2oTicketRepository.findBySessionIdRowNumberPlaceNumber(
                ticket.getSessionId(), ticket.getRowNumber(), ticket.getPlaceNumber()).get();
        assertThat(savedTicket).usingRecursiveComparison().isEqualTo(ticket);
    }

    @Test
    public void whenAddingUsersWithTheSameMailThenEmpty() {
        sql2oTicketRepository.save(new Ticket(1, 2, 3, 4));
        assertThat(sql2oTicketRepository.save(new Ticket(1, 2, 3, 4))).isEmpty();
    }

}