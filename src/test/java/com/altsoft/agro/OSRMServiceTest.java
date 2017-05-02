package com.altsoft.agro;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class OSRMServiceTest {

    private final String SERVICE_URL = "";
    private static CloseableHttpClient client;

    @BeforeClass
    public static void init() {
        client = HttpClients
                .createDefault();
    }

    @AfterClass
    public static void destroy() throws IOException {
        client.close();
    }

    @Test
    public void checkService() throws IOException {
        //Arrange
        HttpGet request = new HttpGet(SERVICE_URL);
        //Act
        HttpResponse response = client.execute(request);
        //Assert
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        // Добавить проверки на содержимое ответа если необходимо
    }

}
