package com.shopcart.assistant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.shopcart.model.common.chat.ChatResponse;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChatGptProxy {

    private final WebClient openAiWebClient;

    public Mono<ChatResponse> askAssistant(String message) {
        ObjectNode payload = buildPayload(message);

        return openAiWebClient.post()
                .uri("/responses")
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(this::mapReply);
    }

    private ObjectNode buildPayload(String message) {
        ObjectNode node = JsonMapper.builder().build().createObjectNode();
        node.put("model", "gpt-4.1-mini");
        node.put("input", message);
        return node;
    }


    private ChatResponse mapReply(JsonNode json) {
        String content = json.path("output")
                .path(0)
                .path("content")
                .path(0)
                .path("text")
                .asText("No pude obtener respuesta.");

        return ChatResponse.builder()
                .reply(content)
                .build();
    }

}

