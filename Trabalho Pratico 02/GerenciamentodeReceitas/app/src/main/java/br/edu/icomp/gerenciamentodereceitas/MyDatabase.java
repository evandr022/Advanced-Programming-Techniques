package br.edu.icomp.gerenciamentodereceitas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

class MyDatabase extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "CookBook.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Recipes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TIPO = "Tipo";
    private static final String COLUMN_NOME = "Nome";
    private static final String COLUMN_INGREDIENTES = "Ingredientes";
    private static final String COLUMN_PREPARO = "Preparo";
    private static final String COLUMN_CALORIAS = "Calorias";
    private static final String COLUMN_TEMPO = "Tempo";
    private static final String COLUMN_AVALIACAO = "Avaliacao";
    private static final String COLUMN_IMAGEM = "Imagem";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TIPO + " TEXT, " +
                COLUMN_NOME + " TEXT, " +
                COLUMN_INGREDIENTES + " TEXT, " +
                COLUMN_PREPARO + " TEXT, " +
                COLUMN_CALORIAS + " INTEGER, " +
                COLUMN_TEMPO + " INTEGER, " +
                COLUMN_AVALIACAO + " INTEGER, " +
                COLUMN_IMAGEM + " BLOB);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addRecipe(String tipo,String nome, String ingredientes, String preparo, int calorias, int tempo, int avaliacao, byte[] imagem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TIPO, tipo);
        cv.put(COLUMN_NOME, nome);
        cv.put(COLUMN_INGREDIENTES, ingredientes);
        cv.put(COLUMN_PREPARO, preparo);
        cv.put(COLUMN_CALORIAS, calorias);
        cv.put(COLUMN_AVALIACAO, avaliacao);
        cv.put(COLUMN_IMAGEM, imagem);

        long result = db.insert(TABLE_NAME, null, cv);

        if(result == -1){
            Toast.makeText(context, "Falhou ao salvar", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
        }
    }
}
