package org.example;

import grpc.java.project.HelloRequest;
import grpc.java.project.HelloResponse;
import grpc.java.project.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setName("John").build();
        HelloResponse response = stub.sayHello(request);

        System.out.println("Server response: " + response.getGreeting());

        channel.shutdown();
    }
}
