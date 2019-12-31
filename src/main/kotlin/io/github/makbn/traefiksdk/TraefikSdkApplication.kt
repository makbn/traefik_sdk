package io.github.makbn.traefiksdk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

@SpringBootApplication
class TraefikSdkApplication : ApplicationListener<ContextRefreshedEvent> {

	override fun onApplicationEvent(event: ContextRefreshedEvent) {
		print(event)
	}

}

fun main(args: Array<String>) {
	runApplication<TraefikSdkApplication>(*args)

}
