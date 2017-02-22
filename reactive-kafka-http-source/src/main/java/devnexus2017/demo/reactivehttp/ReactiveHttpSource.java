package devnexus2017.demo.reactivehttp;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.reactive.ReactiveSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@SpringBootApplication
@Controller
@EnableBinding(ReactiveSource.class)
public class ReactiveHttpSource {

	@Autowired
	ReactiveSource source;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveHttpSource.class, args);
	}

	@PostMapping(path = "${http.pathPattern:/}", consumes = {"text/*", "application/json"})
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	Mono<Void> receiveData(@RequestBody Flux<String> input, @RequestHeader(HttpHeaders.CONTENT_TYPE) Object contentType) {
		return source.output().send(input.map(s -> MessageBuilder.withPayload(s).setHeader(MessageHeaders.CONTENT_TYPE, contentType).build()));
	}
}
