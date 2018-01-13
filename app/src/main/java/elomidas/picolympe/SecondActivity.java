package elomidas.picolympe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity
{
    protected ArrayList<String> _players;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final Button bdel = (Button)findViewById(R.id.button_del);
        bdel.setTextColor(Color.GRAY);
        bdel.setEnabled(false);
        final Button bnext = (Button)findViewById(R.id.button_next);
        bnext.setTextColor(Color.GRAY);
        bnext.setEnabled(false);
        final Button badd = (Button)findViewById(R.id.button_add);
        badd.setTextColor(Color.WHITE);


        //Récupérer les noms
        Intent in = getIntent();
        int taille = in.getIntExtra("Taille", 0);
        for(int i = 0; i < taille; i++)
        {
            String str = in.getStringExtra("P" + i);
            Add(str);
        }

        if(taille > 1)
        {
            if(taille > 2)
            {
                bdel.setEnabled(true);
                bdel.setTextColor(Color.WHITE);
            }
            bnext.setEnabled(true);
            bnext.setTextColor(Color.WHITE);
        }

        bdel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final LinearLayout lay = (LinearLayout)findViewById(R.id.liste);
                lay.removeViewAt(lay.getChildCount() - 1);
                if(lay.getChildCount() < 3)
                {
                    bdel.setEnabled(false);
                    bdel.setTextColor(Color.GRAY);
                    if(lay.getChildCount() < 2)
                    {
                        bnext.setEnabled(false);
                        bnext.setTextColor(Color.GRAY);
                    }
                }
            }
        });

        bnext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(getNames())
                {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    intent.putExtra("Taille", _players.size());
                    for(int i = 0; i < _players.size(); i++)
                        intent.putExtra("P" + i, _players.get(i));
                    startActivity(intent);
                }
            }
        });

        badd.setEnabled(true);
        badd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int taille = Add("");
                if(taille > 1)
                {
                    if(taille > 2)
                    {
                        bdel.setEnabled(true);
                        bdel.setTextColor(Color.WHITE);
                    }
                    bnext.setEnabled(true);
                    bnext.setTextColor(Color.WHITE);
                }
            }
        });
    }

    protected int Add(String name)
    {
        final LinearLayout lay = (LinearLayout)findViewById(R.id.liste);
        EditText ed = new EditText(SecondActivity.this);
        ed.setTextColor(Color.WHITE);
        ed.setText(name.equals("") ? "J" + (lay.getChildCount() + 1) : name);
        lay.addView(ed);
        return lay.getChildCount();
    }

    protected boolean getNames()
    {
        _players = new ArrayList<>();
        final LinearLayout lay = (LinearLayout)findViewById(R.id.liste);
        for(int i = 0; i < lay.getChildCount(); i++)
        {
            String str = ((EditText)lay.getChildAt(i)).getText().toString();
            if(_players.contains(str))
                return false;
            _players.add(str);
        }
        return true;
    }
}
