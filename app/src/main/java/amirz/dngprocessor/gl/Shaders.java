package amirz.dngprocessor.gl;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import amirz.dngprocessor.R;

public class Shaders {
    public static String VS;
    public static String FS1;
    public static String FS2;
    public static String FS3;

    public static void load(Context context) {
        Resources res = context.getResources();

        VS = readRaw(res, R.raw.passthrough_vs);

        FS1 = readRaw(res, R.raw.stage1_fs);
        FS2 = readRaw(res, R.raw.stage2_fs);
        FS3 = readRaw(res, R.raw.stage3_fs);
    }

    private static String readRaw(Resources res, int resId) {
        try (InputStream inputStream = res.openRawResource(resId)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder text = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }

            return text.toString();
        } catch (IOException e) {
            return null;
        }
    }
}
