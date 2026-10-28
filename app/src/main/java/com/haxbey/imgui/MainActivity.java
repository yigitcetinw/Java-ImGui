package com.haxbey.imgui;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int OVERLAY_PERMISSION_REQ_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Arayüz oluşturma (Basit Java UI)
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 50, 50, 50);

        Button btnStart = new Button(this);
        btnStart.setText("ImGui Menuyu Baslat");
        btnStart.setOnClickListener(v -> {
            if (checkOverlayPermission()) {
                startImGuiMenu();
            }
        });

        layout.addView(btnStart);
        setContentView(layout);
    }

    private boolean checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
                return false;
            }
        }
        return true;
    }

    private void startImGuiMenu() {
        // Native kütüphaneyi ve ImGui thread'ini tetikle
        NativeLib.startImGui();
        Toast.makeText(this, "ImGui Menü Arka Planda Aktif Edildi!", Toast.LENGTH_SHORT).show();
    }
}
