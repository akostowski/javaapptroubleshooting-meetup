package pl.akostowski.qr;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.RawFileBodyPart;
import static io.gatling.javaapi.http.HttpDsl.flushSessionCookies;
import static io.gatling.javaapi.http.HttpDsl.http;

public class BasicSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8083/qr");

    ScenarioBuilder scn = scenario("Znajdowanie QR kodow").repeat(10).on(exec(http("request1")
            .post("/find")
            .bodyPart(RawFileBodyPart("file", "C:\\Users\\Olek\\IdeaProjects\\javaapptroubleshooting-meetup\\qrcodereader\\requests\\latawce.tiff"))
    ).exec(flushSessionCookies()));

    {
        setUp(scn.injectOpen(atOnceUsers(1)).protocols(httpProtocol));
    }
}