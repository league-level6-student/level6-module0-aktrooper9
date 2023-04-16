package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {

    NewsApi newsApi;

    @BeforeEach
    void setUp() {
MockitoAnnotations.openMocks(this);
newsApi = new NewsApi();
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
        boolean expected = true;
        boolean actual;
if(newsApi.getNewsStoryByTopic("pizza")!=null){
    actual=true;
        }
else{
    actual=false;
}
        //when

        //then
        assertEquals(actual,expected);

    }

    @Test
    void itShouldFindStory(){
        //given
        String url=newsApi.findStory("pizza");
        System.out.println(url);
        //when
        //then
        assertEquals(url,"Fries Are a Crouton -\n" +
                "Pendants will tell you a crouton is piece of cubed bread, tossed in oil and seasoning and baked or fried until crunchy, but a crouton is merely a construct. If it provides textural contrast to a pile… [+1856 chars]\n" +
                "Full article: https://lifehacker.com/fries-are-a-crouton-1850289396");
    }


}