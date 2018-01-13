package elomidas.picolympe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FirstActivity extends AppCompatActivity
{
    View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("Taille", 2);
                intent.putExtra("P0", "J1");
                intent.putExtra("P1", "J2");
                startActivity(intent);
            }
        });
    }
}
