Reproduces a problem with (chained) property converters.

**Solved:** Layer 8 problem; needed to use `@Component` instead of `@Configuration` [on that converter](https://github.com/reitzig/issue-reproduction/blob/4c53ea2405b7b5ab69caeaad05994438ad026a11/spring-boot-converter-chain/src/main/java/repro/converters/TestBarConverter.java#L10). A silly copy-paste or tinkering leftover indeed -- the behaviour of Spring Boot still puzzles me, though!
