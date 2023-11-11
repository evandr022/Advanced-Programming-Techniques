package br.edu.icomp.gerenciamentodereceitas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.io.ByteArrayOutputStream;

public class activity_cadastro extends AppCompatActivity {

    EditText recipeNameEditText, ingredientsEditText, cookingInstructionsEditText, caloriesEditText, preparationTimeEditText;
    Spinner recipeTypeSpinner;
    ImageButton imageButton2;
    RatingBar ratingBar;
    Button buttonSalve;

    private String[] recipeTypes = {"Entradas", "Carnes", "Aves", "Vegetariano", "Doces", "Salgados"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        recipeTypeSpinner = findViewById(R.id.recipeTypeSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, recipeTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recipeTypeSpinner.setAdapter(adapter);

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Escolha sua imagem"), 1);
            }
        });

        private byte[] getImageBytes() {
            // Verifique se uma imagem foi selecionada e converta-a em um array de bytes
            if (imageButton2.getDrawable() != null) {
                Bitmap bitmap = ((BitmapDrawable) imageButton2.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            return null; // Handle the case where no image is selected
        }

        //recipeTypeSpinner = findViewById(R.id.recipeTypeSpinner);
        recipeNameEditText = findViewById(R.id.recipeNameEditText);
        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        cookingInstructionsEditText = findViewById(R.id.cookingInstructionsEditText);
        caloriesEditText = findViewById(R.id.caloriesEditText);
        preparationTimeEditText = findViewById(R.id.preparationTimeEditText);
        ratingBar = findViewById(R.id.ratingBar);
        //imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        buttonSalve = findViewById(R.id.buttonSalve);

        buttonSalve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabase myDB = new MyDatabase(activity_cadastro.this);
                myDB.addRecipe(
                        recipeNameEditText.getText().toString().trim(),
                        recipeTypeSpinner.getSelectedItem().toString(),
                        ingredientsEditText.getText().toString().trim(),
                        cookingInstructionsEditText.getText().toString().trim(),
                        Integer.parseInt(caloriesEditText.getText().toString().trim()),
                        Integer.parseInt(preparationTimeEditText.getText().toString().trim()),
                        ratingBar.getRating(),
                        getImageBytes() // Call the getImageBytes() method here
                );
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            imageButton2.setImageURI(data.getData());
        }
    }

    public void clickSalvar(View view){
        Intent intent = new Intent(this, activity_cadastro.class);
        startActivity(intent);
    }
}
