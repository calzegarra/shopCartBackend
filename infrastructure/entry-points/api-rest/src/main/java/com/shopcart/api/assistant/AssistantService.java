package com.shopcart.api.assistant;

import com.shopcart.assistant.ChatGptProxy;
import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.chat.ChatRequest;
import com.shopcart.model.common.chat.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/chatgpt", produces = "application/json")
@RequiredArgsConstructor
public class AssistantService {
    private final ChatGptProxy service;

    private static final Logger log = LoggerFactory.getLogger(AssistantService.class);

    @PostMapping("/ask")
    public Mono<ResponseData<ChatResponse>> ask(@RequestBody ChatRequest request) {
        return service.askAssistant(request.getMessage())
                .map(reply -> ResponseData.<ChatResponse>builder()
                        .status(true)
                        .code(HttpStatus.OK.value())
                        .message("OK")
                        .data(reply)
                        .build())
                .onErrorResume(ex -> {
                    log.error("Error contactando OpenAI", ex);   // <--- log real
                    return Mono.just(ResponseData.<ChatResponse>builder()
                            .status(false)
                            .code(HttpStatus.BAD_GATEWAY.value())
                            .message("No se pudo contactar al asistente.")
                            .data(ChatResponse.builder().reply("Error interno, intenta más tarde.").build())
                            .build());
                });
    }
}