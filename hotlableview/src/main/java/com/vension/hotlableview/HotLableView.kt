package com.vension.hotlableview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View

/**
 * ===================================================================
 * @author: Created by Vension on 2019/1/14 16:17.
 * @email:  250685***4@qq.com
 * @update: update by *** on 2019/1/14 16:17
 * @desc:   一个简单实用的标签控件,轻松添加最新最热等标签
 * ===================================================================
 */
class HotLableView @JvmOverloads constructor(context: Context,val attrs: AttributeSet? = null,defStyleAttr: Int = 0)
    : View(context,attrs,defStyleAttr) {

    //标签文本
    private lateinit var mTextContent: String
    //文本颜色
    private var mTextColor: Int = 0
    //文本大小
    private var mTextSize: Float = 0.toFloat()
    //文本是否加粗
    private var mTextBold: Boolean = false
    //是否填充三角区
    private var mFillTriangle: Boolean = false
    //是否支持英文全大写
    private var mTextAllCaps: Boolean = false
    //背景色
    private var mBackgroundColor: Int = 0
    //最小尺寸
    private var mMinSize: Float = 0.toFloat()
    private var mPadding: Float = 0.toFloat()
    private var mGravity: Int = 0
    private val DEFAULT_DEGREES = 45

    private val mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mBackgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mPath = Path()
    private var mFillSize: Int = 0

    init {
        initTypedArray()
        //设置画笔
        initPaint()
    }

    private fun initTypedArray() {
        //获取自定义属性
        val ta = context.obtainStyledAttributes(attrs, R.styleable.HotLabelView)
        mFillSize = ta.getInt(R.styleable.HotLabelView_hlv_fillSize, 0)
        mTextContent = ta.getString(R.styleable.HotLabelView_hlv_text)
        mTextColor = ta.getColor(R.styleable.HotLabelView_hlv_textColor, Color.parseColor("#ffffff"))
        mTextSize = ta.getDimension(R.styleable.HotLabelView_hlv_textSize, sp2px(11f).toFloat())
        mTextBold = ta.getBoolean(R.styleable.HotLabelView_hlv_textBold, true)
        mTextAllCaps = ta.getBoolean(R.styleable.HotLabelView_hlv_textAllCaps, true)
        mFillTriangle = ta.getBoolean(R.styleable.HotLabelView_hlv_fillTriangle, false)
        mBackgroundColor = ta.getColor(R.styleable.HotLabelView_hlv_bgColor, Color.parseColor("#FF4081"))
        mMinSize = ta.getDimension(R.styleable.HotLabelView_hlv_minSize, (if (mFillTriangle) dp2px(35f) else dp2px(50f)).toFloat())
        mPadding = ta.getDimension(R.styleable.HotLabelView_hlv_padding, dp2px(3.5f).toFloat())
        mGravity = ta.getInt(R.styleable.HotLabelView_hlv_gravity, Gravity.TOP or Gravity.LEFT)
        ta.recycle()
    }

    private fun initPaint() {
        mTextPaint.textAlign = Paint.Align.CENTER
        mTextPaint.color = mTextColor
        mTextPaint.textSize = mTextSize
        mTextPaint.isFakeBoldText = mTextBold
        mBackgroundPaint.color = mBackgroundColor
    }


    /**
     *  计算View宽度大小
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var measuredWidth :Int
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specSize = MeasureSpec.getSize(widthMeasureSpec)
        if (specMode == MeasureSpec.EXACTLY){
            //大小确定直接使用
            measuredWidth = specSize
        }else{
            val padding = paddingLeft + paddingRight
            mTextPaint.textSize = mTextSize
            //计算文本的宽度
            val textWidth = mTextPaint.measureText(mTextContent + "")
            measuredWidth = ((padding + textWidth.toInt()) * Math.sqrt(2.0)).toInt()
            //如果父视图的测量要求为AT_MOST,即限定了一个最大值,则再从系统建议值和自己计算值中去一个较小值
            if (specMode == View.MeasureSpec.AT_MOST) {
                measuredWidth = Math.min(measuredWidth, specSize)
            }
            measuredWidth = Math.max(mMinSize.toInt(), measuredWidth)
        }
        //计算完之后需要重新设置尺寸
        setMeasuredDimension(measuredWidth,measuredWidth)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val size = height
        val textHeight = mTextPaint.descent() - mTextPaint.ascent()
        val i = dp2px(mFillSize.toFloat())
        if (mFillTriangle) {
            if (mGravity == Gravity.TOP or Gravity.LEFT) {
                mPath.reset()
                mPath.moveTo(0f, 0f)
                mPath.lineTo(0f, size.toFloat())
                mPath.lineTo(size.toFloat(), 0f)
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawTextWhenFill(size, (-DEFAULT_DEGREES).toFloat(), canvas, true)
            } else if (mGravity == Gravity.TOP or Gravity.RIGHT) {
                mPath.reset()
                mPath.moveTo(size.toFloat(), 0f)
                mPath.lineTo(0f, 0f)
                mPath.lineTo(size.toFloat(), size.toFloat())
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawTextWhenFill(size, DEFAULT_DEGREES.toFloat(), canvas, true)
            } else if (mGravity == Gravity.BOTTOM or Gravity.LEFT) {
                mPath.reset()
                mPath.moveTo(0f, size.toFloat())
                mPath.lineTo(0f, 0f)
                mPath.lineTo(size.toFloat(), size.toFloat())
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawTextWhenFill(size, DEFAULT_DEGREES.toFloat(), canvas, false)
            } else if (mGravity == Gravity.BOTTOM or Gravity.RIGHT) {
                mPath.reset()
                mPath.moveTo(size.toFloat(), size.toFloat())
                mPath.lineTo(0f, size.toFloat())
                mPath.lineTo(size.toFloat(), 0f)
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawTextWhenFill(size, (-DEFAULT_DEGREES).toFloat(), canvas, false)
            }
        } else {
            val delta = (textHeight + mPadding * 2) * Math.sqrt(2.0)
            if (mGravity == Gravity.TOP or Gravity.LEFT) {
                mPath.reset()
                mPath.moveTo(0f, (size - delta).toFloat() - i)
                mPath.lineTo(0f, (size - i).toFloat())
                mPath.lineTo(i.toFloat(), size.toFloat())
                mPath.lineTo(i.toFloat(), (size - i * 2).toFloat())
                mPath.lineTo((size - i * 2).toFloat(), i.toFloat())
                mPath.lineTo(size.toFloat(), i.toFloat())
                mPath.lineTo((size - i).toFloat(), 0f)
                mPath.lineTo((size - delta).toFloat() - i, 0f)
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawText(size, (-DEFAULT_DEGREES).toFloat(), canvas, textHeight + i, true)
            } else if (mGravity == Gravity.TOP or Gravity.RIGHT) {
                mPath.reset()
                mPath.moveTo((0 + i).toFloat(), 0f)
                mPath.lineTo(delta.toFloat() + i, 0f)
                mPath.lineTo(size.toFloat(), (size.toDouble() - delta - i.toDouble()).toFloat())
                mPath.lineTo(size.toFloat(), (size - i).toFloat())
                mPath.lineTo((size - i).toFloat(), size.toFloat())
                mPath.lineTo((size - i).toFloat(), (size - i * 2).toFloat())
                mPath.lineTo((i * 2).toFloat(), i.toFloat())
                mPath.lineTo(0f, i.toFloat())
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawText(size, DEFAULT_DEGREES.toFloat(), canvas, textHeight + i, true)
            } else if (mGravity == Gravity.BOTTOM or Gravity.LEFT) {
                mPath.reset()
                mPath.moveTo(i.toFloat(), 0f)
                mPath.lineTo(0f, i.toFloat())
                mPath.lineTo(0f, delta.toFloat() + i)
                mPath.lineTo((size - delta).toFloat() - i, size.toFloat())
                mPath.lineTo((size - i).toFloat(), size.toFloat())
                mPath.lineTo(size.toFloat(), (size - i).toFloat())
                mPath.lineTo((size - i * 2).toFloat(), (size - i).toFloat())
                mPath.lineTo(i.toFloat(), (i * 2).toFloat())
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawText(size, DEFAULT_DEGREES.toFloat(), canvas, textHeight + i, false)
            } else if (mGravity == Gravity.BOTTOM or Gravity.RIGHT) {
                mPath.reset()
                mPath.moveTo(0f, (size - i).toFloat())
                mPath.lineTo(i.toFloat(), size.toFloat())
                mPath.lineTo(delta.toFloat() + i, size.toFloat())
                mPath.lineTo(size.toFloat(), delta.toFloat() + i)
                mPath.lineTo(size.toFloat(), i.toFloat())
                mPath.lineTo((size - i).toFloat(), 0f)
                mPath.lineTo((size - i).toFloat(), (i * 2).toFloat())
                mPath.lineTo((i * 2).toFloat(), (size - i).toFloat())
                mPath.close()
                canvas.drawPath(mPath, mBackgroundPaint)

                drawText(size, (-DEFAULT_DEGREES).toFloat(), canvas, textHeight + i, false)
            }
        }
    }


    private fun drawText(size: Int, degrees: Float, canvas: Canvas, textHeight: Float, isTop: Boolean) {
        canvas.save()
        canvas.rotate(degrees, size / 2f, size / 2f)
        val delta = if (isTop) -(textHeight + mPadding * 2) / 2 else (textHeight + mPadding * 2) / 2
        val textBaseY = size / 2 - (mTextPaint.descent() + mTextPaint.ascent()) / 2 + delta
        canvas.drawText(
            if (mTextAllCaps) mTextContent.toUpperCase() else mTextContent,
            (paddingLeft + (size - paddingLeft - paddingRight) / 2).toFloat(), textBaseY, mTextPaint
        )
        canvas.restore()
    }

    private fun drawTextWhenFill(size: Int, degrees: Float, canvas: Canvas, isTop: Boolean) {
        canvas.save()
        canvas.rotate(degrees, size / 2f, size / 2f)
        val delta = (if (isTop) -size / 4 else size / 4).toFloat()
        val textBaseY = size / 2 - (mTextPaint.descent() + mTextPaint.ascent()) / 2 + delta
        canvas.drawText(
            if (mTextAllCaps) mTextContent.toUpperCase() else mTextContent,
            (paddingLeft + (size - paddingLeft - paddingRight) / 2).toFloat(), textBaseY, mTextPaint
        )
        canvas.restore()
    }


    /**
     * dp转px
     *
     * @param dpVal
     * @return
     */
    fun dp2px( dpVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.resources.displayMetrics).toInt()
    }

    /**
     * sp转px
     * @param spVal
     * @return
     */
    fun sp2px(spVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.resources.displayMetrics).toInt()
    }


    /** ==================== 以下是对外开发的拓展方法 =========================*/

    fun setText(text: String) {
        mTextContent = text
        invalidate()
    }

    fun setTextSize(textSize: Float) {
        mTextSize = sp2px(textSize).toFloat()
        invalidate()
    }

    fun setTextBold(textBold: Boolean) {
        mTextBold = textBold
        invalidate()
    }

    fun setFillTriangle(fillTriangle: Boolean) {
        mFillTriangle = fillTriangle
        invalidate()
    }

    fun setTextAllCaps(textAllCaps: Boolean) {
        mTextAllCaps = textAllCaps
        invalidate()
    }

    fun setBgColor(backgroundColor: Int) {
        mBackgroundColor = backgroundColor
        invalidate()
    }

    fun setMinSize(minSize: Float) {
        mMinSize = dp2px(minSize).toFloat()
        invalidate()
    }

    fun setPadding(padding: Float) {
        mPadding = dp2px(padding).toFloat()
        invalidate()
    }

    /**
     * Gravity.TOP | Gravity.LEFT
     * Gravity.TOP | Gravity.RIGHT
     * Gravity.BOTTOM | Gravity.LEFT
     * Gravity.BOTTOM | Gravity.RIGHT
     */
    fun setGravity(gravity: Int) {
        mGravity = gravity
    }

    fun getText(): String {
        return mTextContent
    }

    fun getTextColor(): Int {
        return mTextColor
    }

    fun getTextSize(): Float {
        return mTextSize
    }

    fun isTextBold(): Boolean {
        return mTextBold
    }

    fun isFillTriangle(): Boolean {
        return mFillTriangle
    }

    fun isTextAllCaps(): Boolean {
        return mTextAllCaps
    }

    fun getBgColor(): Int {
        return mBackgroundColor
    }

    fun getMinSize(): Float {
        return mMinSize
    }

    fun getPadding(): Float {
        return mPadding
    }

    fun getGravity(): Int {
        return mGravity
    }

}