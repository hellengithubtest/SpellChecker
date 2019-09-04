package hello;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SpellClient extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request) {
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }

/*    public void printResponse(GetCityForecastByZIPResponse response) {
        ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();

        if (forecastReturn.isSuccess()) {
            System.out.println();
            System.out.println("Forecast for " + forecastReturn.getCity() + ", "
                    + forecastReturn.getState());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {
                System.out.print(format.format(forecast.getDate().toGregorianCalendar().getTime()));
                System.out.print(" ");
                System.out.print(forecast.getDesciption());
                System.out.print(" ");
                Temp temperature = forecast.getTemperatures();
                System.out.print(temperature.getMorningLow() + "\u00b0-"
                        + temperature.getDaytimeHigh() + "\u00b0 ");
                System.out.println();
            }
        } else {
            System.out.println("No forecast received");
        }
    }*/

}
