package kr.hs.emirim.sagittta.sulbam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setToolbar();

//        navigationView.setNavigationItemSelectedListener(this)

        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }

    private void setToolbar() {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_hbg);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.showAll -> Snackbar.make(
                    toolbar, "우선순위 설정", Snackbar.LENGTH_SHORT).show();

            R.id.showTheme -> Snackbar.make(
                    toolbar, "알람 설정", Snackbar.LENGTH_SHORT).show();

            R.id.ask -> Snackbar.make(
                    toolbar, "검색", Snackbar.LENGTH_SHORT).show();

            R.id.setting -> Snackbar.make(
                    toolbar, "설정", Snackbar.LENGTH_SHORT).show();

            R.id.bug_report -> Snackbar.make(
                    toolbar, "오류 전송", Snackbar.LENGTH_SHORT).show();

        }
        drawerLayout.closeDrawers();
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
