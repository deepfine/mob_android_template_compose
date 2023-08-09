package com.deepfine.presentation.utils

import android.app.Dialog
import android.content.Context
import android.graphics.PorterDuff
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import com.deepfine.presentation.R

/**
 * @author hj.kim (DEEP.FINE)
 * @version 1.0.0
 * @Description 공통 Indicator
 * @since 2020-12-21
 */
object DeepFineIndicator {
  private var mDialog: Dialog? = null

  // o_dialog 보여짐
  fun showLoading(context: Context?) {
    if (mDialog == null) {
      mDialog = Dialog(context!!, R.style.CustomIndicator)
      val progressBar = ProgressBar(context)
      progressBar.isIndeterminate = true
      progressBar.indeterminateDrawable.setColorFilter(
        ContextCompat.getColor(context, R.color.blue_0089ff),
        PorterDuff.Mode.MULTIPLY
      )

      // 컨트롤의 크기를 결정하기 위한 LayoutParams 객체를 생성한다.
      // 파라미터에 가로 크기와 세로크기를 지정해 준다.
      // 대부분 컨트롤의 기본 사이즈를 적용하기 위한 LayoutParams.WRAP_CONTENT 값을 지정한다.
      val params = ViewGroup.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
      )

      // 다이얼로그 창에, 컨트롤을 추가한다.
      // 첫번째 파라미터인 view 객체는 다이얼로그에 추가할 컨트롤 요소이다.
      // 두번째 파라미터인 params 객체는 컨트롤에 대한 사이즈 정보를 담은 LayoutParams 객체이다.
      mDialog!!.addContentView(progressBar, params)

      // 다이얼로그 창을 하드웨어 BACK 키를 통해서 닫을 수 있는지의 여부를 결정한다.
      // false로 파라미터가 전달될 경우 다이얼로그 창은 BACK 키를 통해서 닫을 수 없게 설정된다.
      mDialog!!.setCancelable(false)
    }

    // 다이얼로그 창을 화면에 표시한다.
    try {
      mDialog!!.show()
    } catch (e: Exception) {
      mDialog = null
    }
  }

  val isShowing: Boolean
    get() {
      var bShowing = false
      try {
        bShowing = mDialog != null && mDialog!!.isShowing
      } catch (e: Exception) {
        e.printStackTrace()
      }
      return bShowing
    }

  // o_dialog 사라짐
  fun hideLoading() {
    try {
      if (mDialog != null && mDialog!!.isShowing) {
        mDialog!!.dismiss()
        mDialog = null
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}