package com.softserve.itacademy.controller.integration;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

class DeleteTaskServletIT extends BaseIT {

    @Test
    @Order(1)
    @DisplayName("GET /delete-task with valid ID should redirect to /tasks-list")
    void testValidGetRequest() {
        assumeTrue(isServerAvailable(), "Skipping test because server is not available");

        int taskId = testTasks.get(0).getId();

        try {
            WebTestClient.bindToServer()
                    .baseUrl("http://localhost:" + WEB_PORT)
                    .build()
                    .method(HttpMethod.GET)
                    .uri("/delete-task?id=" + taskId)
                    .exchange()
                    .expectStatus().isFound()
                    .expectHeader().location("/tasks-list");
        } catch (Exception e) {
            System.out.println("[DEBUG_LOG] Error in testValidGetRequest: " + e.getMessage());
            Assertions.fail("Test failed with exception: " + e.getMessage());
        }
    }

    @Test
    @Order(2)
    @DisplayName("GET /delete-task with invalid ID should return 404/Error Page")
    void testInvalidGetRequest() {
        assumeTrue(isServerAvailable(), "Skipping test because server is not available");
        int nonExistentId = testTasks.size() + 100;

        try {
            WebTestClient.bindToServer()
                    .baseUrl("http://localhost:" + WEB_PORT)
                    .build()
                    .method(HttpMethod.GET)
                    .uri("/delete-task?id=" + nonExistentId)
                    .exchange()
                    .expectStatus().isOk()
                    .expectHeader().contentType("text/html;charset=UTF-8");
        } catch (Exception e) {
            System.out.println("[DEBUG_LOG] Error in testInvalidGetRequest: " + e.getMessage());
            Assertions.fail("Test failed with exception: " + e.getMessage());
        }
    }
}
