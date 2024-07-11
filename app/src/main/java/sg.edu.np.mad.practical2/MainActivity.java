package sg.edu.np.mad.practical2;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize a new User object
        User user = new User("John doe","MAD Developer",1,false);

        //Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.main);
        @SuppressLint("CutPasteId") TextView tvDescription = findViewById(R.id.button);
        @SuppressLint("CutPasteId") Button bthFollow = findViewById (R.id.button);

        //Set the TextViews with the User's name, desc. and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        bthFollow.setText("Follow");


    }

}
