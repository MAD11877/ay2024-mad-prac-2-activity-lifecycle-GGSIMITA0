package sg.edu.np.mad.practical2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable Edge-to-Edge (optional)
        EdgeToEdge.enable(this);

        // Set content view
        setContentView(R.layout.activity_main);

        // Initialize User object (Replace with actual User class)
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Get references to views
        TextView tvName = findViewById(R.id.helloTextView);
        TextView tvDescription = findViewById(R.id.loremTextView);
        Button btnFollow = findViewById(R.id.followButton);

        // Set text in TextViews
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText(user.followed ? "Unfollow" : "Follow");

        // Set click listener for the follow button (add this)
        btnFollow.setOnClickListener(view -> {
            user.followed = !user.followed; // Toggle the followed state
            btnFollow.setText(user.followed ? "Unfollow" : "Follow"); // Update button text});


            // Handle WindowInsets (optional, for edge-to-edge display)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imageView), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        });
    }
}

