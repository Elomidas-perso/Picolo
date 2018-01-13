package elomidas.picolympe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity
{
    TextView mContentView;
    protected Jeu _jeu;
    protected ArrayList<String> _players;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _players = new ArrayList<>();

        //Récupérer les noms
        Intent in = getIntent();
        int taille = in.getIntExtra("Taille", 0);
        for(int i = 0; i < taille; i++)
        {
            _players.add(in.getStringExtra("P" + i));
        }

        _jeu = new Jeu(_players);

        setContentView(R.layout.activity_third);

        mContentView = (TextView)findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Next();
            }
        });

        //On affiche la première manche
        Next();
    }

    protected void Next()
    {
        if(mContentView.getText().equals("The Game Is Over"))
        {
            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
            intent.putExtra("Taille", _players.size());
            for(int i = 0; i < _players.size(); i++)
                intent.putExtra("P" + i, _players.get(i));
            startActivity(intent);
        }
        else mContentView.setText(_jeu.Tour());
    }
}
