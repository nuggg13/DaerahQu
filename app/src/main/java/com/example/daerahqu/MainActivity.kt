package com.example.daerahqu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Daftar kuis
        val quizzes = listOf(
            Quiz(
                name = "Kuis Pengetahuan Sriwijaya",
                description = "Berisi soal soal mengenai sejarah kerajaan sriwijaya",
                questions = listOf(
                    Question("apa itu kerajaan sriwijaya ?", listOf("pemerintahan", "pedesaan", "Kedatuan histori dari sumatra", "klub bola"), 2),
                    Question("kerajaan sriwijaya merupakan kerajaan terbesar dalam bidang?", listOf("maritim", "pertanian", "armada perang", "luas wilayah"), 0),
                    Question("kerajaan sriwijaya terlahir pada abad ke..... masehi", listOf("abad ke 3", "abad ke 5", "abad ke 7", "abad ke 10"), 2),
                    Question("dari mana nama sriwijaya di ambil ?", listOf("dari seorang raja yang bosan", "dari bahasa sansekerta", "perebutan 2 raja", "dari perkawinan sri dan wijaya"), 1),
                    Question("puncak gemilangnya kerajaan sriwijaya bermulai pada abad ?", listOf("2 sampai 3", "3 sampai 4", "8 sampai 9", "20 sampai 21"), 2),
                    Question("Kerajaan Sriwijaya terkenal sebagai pusat pendidikan agama Buddha pada abad ke-7. Apa nama pusat pendidikan di India yang sering dikunjungi oleh para biksu dari Sriwijaya?", listOf("Nalanda", "Taxila", "Varanasi", "Sarnath"), 0),
                    Question("Kerajaan Sriwijaya dikenal sebagai pusat perdagangan internasional. Apa jalur utama perdagangan yang dikuasai Sriwijaya?", listOf("Jalur Sutra Darat", "Jalur Sutra Laut", "Jalur Rempah", "Jalur Kapur Barus"), 1),
                    Question("Apa isi utama Prasasti Talang Tuo?", listOf("Pendirian taman untuk kesejahteraan rakyat", "Kemenangan Sriwijaya atas musuh-musuhnya", "Daftar raja-raja Sriwijaya", "Perjanjian dagang dengan Dinasti Tang"), 0),
                    Question("Apa fungsi utama Prasasti Telaga Batu?", listOf("Sebagai sumpah kesetiaan bagi pejabat kerajaan", "Menjelaskan silsilah raja-raja Sriwijaya", "Menandai wilayah kekuasaan Sriwijaya", "Sebagai penanda perjanjian dagang dengan Tiongkok"), 0),
                    Question("Menurut catatan I-Ching, kota utama Kerajaan Sriwijaya disebut sebagai Shih-li-fo-shih. Nama kota ini dipercaya mengacu pada wilayah mana dalam konteks modern?", listOf("Palembang", "Jambi", "Muara Takus", "Bangka"), 0),

                )
            ),
            Quiz(
                name = "Kuis Pengetahuan Majapahit",
                description = "Berisi soal soal mengenai sejarah Kerajaan majapahit",
                questions = listOf(
                    Question("Siapakah raja pertama Kerajaan Majapahit?", listOf("Hayam Wuruk", "Raden Wijaya", "Gajah Mada", "Tribhuwana Tunggadewi"), 1),
                    Question("Sumpah Palapa, yang terkenal dalam sejarah Majapahit, diucapkan oleh?", listOf("Gajah Mada", "Hayam Wuruk", "Adityawarman", "Kertanegara"), 0),
                    Question("Kitab Negarakertagama yang menggambarkan kejayaan Majapahit, ditulis oleh siapa?", listOf("Mpu Gandring", "Mpu Prapanca", "Mpu Sedah", "Mpu Tantular"), 1),
                    Question("Apa nama pelabuhan penting Kerajaan Majapahit yang menjadi pusat perdagangan internasional?", listOf("Sunda Kelapa", "Tanjung Perak", "Tuban", "Gresik"), 2),
                    Question("Faktor utama yang menyebabkan runtuhnya Kerajaan Majapahit adalah...?", listOf("Penyerangan oleh kerajaan asing", "Perang saudara (Perang Paregreg)", "Letusan gunung berapi", "pandemi penyakit"), 1),
                )
            ),
            Quiz(
                name = "Kuis Pengetahuan Aceh",
                description = "Berisi soal soal mengenai sejarah kerajaan aceh",
                questions = listOf(
                    Question("Siapakah sultan pertama Kerajaan Aceh yang membawa kerajaan ini menjadi kekuatan besar di Asia Tenggara?", listOf("Sultan Iskandar Muda", "Sultan Ali Mughayat Syah", "Sultan Iskandar Thani", "Sultan Alauddin Riayat Syah"), 1),
                    Question("Pada masa pemerintahan siapa Kerajaan Aceh mencapai puncak kejayaannya?", listOf("Sultan Iskandar Thani", "Sultan Alauddin Riayat Syah", "Sultan Iskandar Muda", "Sultan Zainal Abidin"), 2),
                    Question("Apa nama undang-undang yang digunakan Sultan Iskandar Muda untuk mengatur pemerintahan Kerajaan Aceh?", listOf("Qanun Aceh", "Adat Aceh", "Hikayat Aceh", "Suluh Aceh"), 0),
                    Question("Siapakah pendiri Kerajaan Aceh?", listOf("Sultan Iskandar Muda", "Sultan Ali Mughayat Syah", "Sultan Iskandar Thani", "Sultan Alauddin Riayat Syah"), 1),
                    Question("tahun berdirinya kesulitanan aceh", listOf("1493", "1494", "1495", "1496"), 3),
                )
            ),
            Quiz(
                name = "Kuis Pengetahuan Mataram Islam",
                description = "Berisi soal soal mengenai sejarah kerajaan mataram islam",
                questions = listOf(
                    Question("Kerajaan Mataram Islam mencapai puncak kejayaan pada masa pemerintahan raja", listOf("Sultan Agung", "Panembahan Senapati", "Amangkurat I", "Raden Patah"), 0),
                    Question("Kerajaan Mataram Islam berpusat di daerah", listOf("Banten", "Surakarta", "Yogyakarta", "Kotagede"), 3),
                    Question("Salah satu strategi Sultan Agung untuk melawan VOC adalah", listOf("Melakukan perang gerilya", "Menjalin persekutuan dengan kerajaan di Maluku", "Menyerang Batavia pada tahun 1628 dan 1629", "Memindahkan ibu kota kerajaan"), 2),
                    Question("Perjanjian Giyanti pada tahun 1755 mengakibatkan", listOf("Kerajaan Mataram Islam mencapai puncak kejayaan", "Pembagian Kerajaan Mataram menjadi Yogyakarta dan Surakarta", "Kerajaan Mataram berhasil menguasai wilayah Batavia", "Penyatuan kerajaan-kerajaan di Jawa"), 1),
                    Question("Kerajaan Mataram Islam Didirikan oleh", listOf("Sultan Trenggana", "Panembahan Senapati", "Ki Ageng Selo", "Sultan Hadiwijaya"), 1),
                )
            ),
        )

        // Mengatur RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewQuizzes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = QuizAdapter(quizzes) { quiz ->
            // Pindah ke activity quiz
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("quiz", quiz)
            startActivity(intent)
        }
    }
}
