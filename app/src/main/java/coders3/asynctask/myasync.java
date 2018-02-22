package coders3.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by welcom on 2/22/2018.
 */

public class myasync  extends AsyncTask{

    ProgressDialog pd;
    Context context;

    myasync(Context context){

        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setTitle("title");
        pd.setMessage("wait please");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMax(10);
        pd.setButton(ProgressDialog.BUTTON_POSITIVE " okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        pd.show();

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            for (int i =1; i<=10;i++){
                Thread.sleep(2000);
                publishProgress(i);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        int value = values[0];
        pd.setProgress(value);
        super.onProgressUpdate(value);
    }
}
