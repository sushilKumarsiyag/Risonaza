package com.risonaza.os.risonaza;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewFlipper vf;
    CardView cardsports,cardtech,cardcultural,cardworkshop;
    TextView textViewsports;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int images[]={R.drawable.rsz_sks3,R.drawable.rsz_sks2,R.drawable.rsz_sks4};
        vf=(ViewFlipper)findViewById(R.id.viewflipper);
        cardsports=(CardView)findViewById(R.id.sportsevent);
        cardtech=(CardView)findViewById(R.id.technicalevent);
        cardcultural=(CardView)findViewById(R.id.clureralevent);
        cardworkshop=(CardView)findViewById(R.id.Workshopevent);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottmnav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.item1:
                        break;
                    case R.id.item2:
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.google.com/maps/place/University+College+of+Engineering+and+Technology,+Bikaner/@28.0670259,73.2870507,796m/data=!3m1!1e3!4m5!3m4!1s0x393fdcc5682c5847:0xdc6da852eca6e3a6!8m2!3d28.0670259!4d73.2892394"));
                        startActivity(intent);
                        break;
                    case R.id.item3:
                        Intent intent1 = new Intent(HomeActivity.this,ContactusActivity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });
        for (int image:images)
        {
            fillperimg(image);
        }


        final Intent intent=getIntent();
        String name=intent.getStringExtra("name");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (name!=null)
        {View headerview=navigationView.getHeaderView(0);
            TextView usernameTextView=headerview.findViewById(R.id.user_profile_name);
            usernameTextView.setText(name);
            Toast.makeText(this, "WelCome \t "+name, Toast.LENGTH_SHORT).show();



        }
        else {
            View headerview=navigationView.getHeaderView(0);
            TextView usernameTextView=headerview.findViewById(R.id.user_profile_name);
            usernameTextView.setText("Guest User");
            Toast.makeText(this, "WelCome in Risonanza", Toast.LENGTH_SHORT).show();


        }

        cardsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(HomeActivity.this,SportsActivity.class);
                startActivity(intent1);
            }
        });

        cardtech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(HomeActivity.this,TechActivity.class);
                startActivity(intent2);
            }
        });

        cardcultural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(HomeActivity.this,culturalActivity.class);
                startActivity(intent3);
            }
        });
        cardworkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "very soon..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fillperimg(int img)
    {
        ImageView imageView=new ImageView(this);

        imageView.setBackgroundResource(img);

        vf.addView(imageView);
        vf.setFlipInterval(4000);
        vf.setAutoStart(true);

        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(HomeActivity.this,AlarmActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.risonaza.os.risonaza"));
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {

            Intent i=new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("email"));
            String[] s={"manglamrkcl2018@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL,s);
            i.setType("message/rfc822");
            startActivity(i);

        } else if (id == R.id.nav_manage) {
            AlertDialog.Builder builder=new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("Developer");
                builder.setMessage("Sushil Kumar Siyag\n"+
                                              "9982462520");
                builder.show();


        } else if (id == R.id.nav_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Risonanza 2019");
            String sAux = "\nRisonanza 2019\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=com.risonaza.os.risonaza";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));


        } else if (id == R.id.nav_send) {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Risonanza 2019");
            String sAux = "\nRisonanza 2019\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=com.risonaza.os.risonaza";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
