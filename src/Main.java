import java.util.ArrayList;

/**
 * Created by corentin on 02/10/17.
 */
public class Main {

    public void map(String key, String value, Context context){
        ArrayList result = new ArrayList<>();
        String[] values = value.split(";");
        for (int i = 0; i<values.length; i++){
            ArrayList<String> current = new ArrayList<>();
            ArrayList line = new ArrayList<>();
            current.add(key);
            current.add(values[i]);
            line.add(current);
            line.add(i);
            result.add(line);
        }
        context.write(result);
    }

    public void reduce(String key, ArrayList<ArrayList> values, Context context){
        ArrayList result = new ArrayList();

        for (int i=0; i<values.size(); i++){
            result.add(Integer.valueOf(values.get(i).get(0).toString()), values.get(i).get(1).toString());
        }

        context.write(result);
    }
}
