package src;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherCity {
    private String town;
    double CurrentValue = 0.0;
    String ApiKey = "&APPID=05366e32393cd84efbd613f4028ba90e";
    String Adress = "http://api.openweathermap.org/data/2.5/find?q=Zelenograd,ru&units=metric"+ApiKey;
    public double getStatusWeather (String Town)
    {
        String Adress = "http://api.openweathermap.org/data/2.5/find?q=" + Town + ",ru&units=metric"+ApiKey;
        try {
            String url = Adress;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // Подключаемся
            con.setRequestMethod("GET");
            //Устанавливаем соединение
            con.setRequestProperty("User-Agent", "Mozilla/5.0"); // Настройки соединения
            int responseCode = con.getResponseCode(); //Получаем код
            System.out.println("\nSending 'GET' request to URL : " + url); //Логируем
            System.out.println("Response Code : " + responseCode); //Логируем
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            System.out.println(response.toString());
            //Read JSON response and print
            //Шагаем до нужного данного, в джсон-массив нулевой элемент-джсон-значение
            JSONObject myResponse = new JSONObject(response.toString());
            JSONObject form_rates = new JSONObject(response.toString());
            JSONArray ArrayHuey = form_rates.getJSONArray("list"); //0 массив
            JSONObject MainFromArray = ArrayHuey.getJSONObject(0);
            JSONObject Temp = MainFromArray.getJSONObject("main");
            //Шагаем до нужного
            System.out.println("result after Reading JSON Response");
            System.out.println("Temp " + Temp.getDouble("temp"));
            CurrentValue=Temp.getDouble("temp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CurrentValue;
    }
}
