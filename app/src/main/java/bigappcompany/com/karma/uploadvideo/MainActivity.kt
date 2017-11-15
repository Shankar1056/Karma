package bigappcompany.com.karma.uploadvideo

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.widget.TextView
import bigappcompany.com.karma.R
import com.seekcircle.SeekCircle



/**
 * @author Shankar <shankar@spotsoon.com>
 * @created on 18 Oct 2017 at 12:20 PM
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_seekbar)

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val density = resources.displayMetrics.density
        val width = dm.widthPixels
        val height = dm.heightPixels
        val d_width = dm.widthPixels/density
        val d_height = dm.heightPixels/density
        val wi = width.toDouble() / dm.xdpi.toDouble()
        val hi = height.toDouble() / dm.ydpi.toDouble()
        val x = Math.pow(wi, 2.0)
        val y = Math.pow(hi, 2.0)
        val screenInches = Math.sqrt(x + y)


        val seekCircle = findViewById(R.id.seekCircle) as SeekCircle
       // val seelprogresscurrency = findViewById(R.id.seelprogresscurrency) as TextView

        seekCircle.setOnSeekCircleChangeListener(object : SeekCircle.OnSeekCircleChangeListener {

            override fun onStopTrackingTouch(seekCircle: SeekCircle) {}

            override fun onStartTrackingTouch(seekCircle: SeekCircle) {}

            override fun onProgressChanged(seekCircle: SeekCircle, progress: Int, fromUser: Boolean) {
              //  updateText()
            }
        })
        //val mSeekArc = findViewById(R.id.seekArc) as SeekArc
       // mSeekArc.setArcWidth(45)
     //   mSeekArc.setArcColor(resources.getColor(R.color.progress_arc_color))
       // mSeekArc.setProgressWidth(45)
      //  mSeekArc.setProgressColor(resources.getColor(R.color.colorAccent))
       /* mSeekArc.setOnSeekArcChangeListener(object : SeekArc.OnSeekArcChangeListener {

            override fun onStopTrackingTouch(seekArc: SeekArc) {}

            override fun onStartTrackingTouch(seekArc: SeekArc) {}

            @SuppressLint("LongLogTag")
            override fun onProgressChanged(seekArc: SeekArc, progress: Int,
                                  fromUser: Boolean) {

                mSeekArcProgress.setText("" + )
                try {
                    seelprogresscurrency.text = "" + ((progress / 10) * 10)
                }
                catch (e:NumberFormatException)
                {
                   // seelprogresscurrency.text = "Error";
                    seekCircle.progress = 0
                }
                catch (e:NullPointerException)
                {
                    seelprogresscurrency.text = "Error";
                    seekCircle.progress = 0
                }
                catch (e:Exception)
                {
                    seelprogresscurrency.text = "Error";
                    seekCircle.progress = 0
                }
                seekCircle.progress = progress
            }
        })

      //  updateText()
*/


    }

   /* private fun updateText() {
        val seekCircle = findViewById(R.id.seekCircle) as SeekCircle
        val textProgress = findViewById(R.id.textProgress) as TextView

        if (textProgress != null && seekCircle != null) {
            val progress = seekCircle!!.progress
            textProgress.text = Integer.toString(progress) + "%"
        }
    }*/

}