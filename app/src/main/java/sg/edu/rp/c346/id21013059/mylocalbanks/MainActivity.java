package sg.edu.rp.c346.id21013059.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import sg.edu.rp.c346.id21013059.mylocalbanks.R;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;
    String bankClicked = "";
    String url = "";
    String tel = "";
    boolean favdbs = false, favocbc = false, favuob = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.textView);
        ocbc = findViewById(R.id.textView2);
        uob = findViewById(R.id.textView3);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, //not inside onCreate, a sibling
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact Bank");


        if (v == dbs) {
            bankClicked = "dbs";

        }

        else if (v == ocbc) {
            bankClicked = "ocbc";

        }

        else if (v == uob) {
            bankClicked = "uob";

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (bankClicked.equalsIgnoreCase(("dbs"))) {
            if (id == androidx.constraintlayout.widget.R.id.actionDown) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page#csb"));
                startActivity(intentCall);
                return true;
            } else if (id == androidx.constraintlayout.widget.R.id.actionUp) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +1800-111-1111"));
                startActivity(intentCall);
            } else {
                return false;

            }

        }

        else if (bankClicked.equalsIgnoreCase(("ocbc"))) {
            if (id == androidx.constraintlayout.widget.R.id.actionUp) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +1800 363 3333"));
                startActivity(intentCall);
            } else {
                return false;
            }}
        else if (bankClicked.equalsIgnoreCase(("uob"))) {
            if (id == R.id.website) {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/digital-banking/index.page?utm_medium=search&utm_source=google&utm_campaign=tmrw22&utm_term=brand&s_cid=grm:sg:paid:sea:go:na:tx:na:tmrw:260422-na:tmrw22:brand:ms-go&vid=mindshare_google&pid=TMRW02_2022Apr&gclid=CjwKCAjws8yUBhA1EiwAi_tpESbsHLplCvCWBmJoCZ0LMBQSw5dhys5Wzk4j5Wn9Ctxf2xhS5D_p1hoCT94QAvD_BwE&gclsrc=aw.ds"));
                startActivity(intentCall);
                return true;
            } else if (id == R.id.contact) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: +1800 222 2121"));
                startActivity(intentCall);
            } else {
                return false;


            }}
        return false;
    }}
