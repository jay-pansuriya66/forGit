package client;

public class TestClient {

    public static void main(String[] args) {

        GarmentClient client = new GarmentClient();

        String result = client.getGarments(
                "mens wear",
                "500-1000"
        );

        System.out.println(result);
    }
}