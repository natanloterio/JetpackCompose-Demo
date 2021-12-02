package com.example.mobileconf.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobileconf.jetpack.ui.theme.Brand1
import com.example.mobileconf.jetpack.ui.theme.Brand3
import com.example.mobileconf.jetpack.ui.theme.Brand5
import com.example.mobileconf.jetpack.ui.theme.JetpackMobileConferenceTheme
import kotlin.math.min

class PDPActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            buildContent()
        }
    }

    @Composable
    private fun buildContent() {
        JetpackMobileConferenceTheme {
                val scrollState = rememberScrollState()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ){
                        ProductCarousel(scrollState)
                        ProductInfo()
                    }
        }
    }

    private @Composable
    fun Tag(label: String) {
        OutlinedButton(
            onClick = {  },
            border = BorderStroke(0.5.dp, Brand1),
            shape = RoundedCornerShape(50), // = 50% percent
            //or shape = CircleShape
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Brand5)
        ){
            Text(
                text = "Non-returnable",
                fontSize = 16.sp,
                style = TextStyle(
                    color = Brand1,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center),
            )
        }
    }

    private @Composable
    fun ProductTags() {
        Row(
            modifier = Modifier.padding(PaddingValues(top = 16.dp))
        ){
            Tag("Black Friday")
            Tag("Non-returnable")
        }
    }

    private @Composable
    fun ProductInfo() {
        Column(
            modifier = Modifier.absolutePadding(left = 16.dp,right = 16.dp,top = 24.dp,bottom = 24.dp)
        ){
            finalSaleTag()
            DesignerName()
            ProductDescription()
            ProductValue()
            ProductTags()
            Spacer(modifier = Modifier.height(16.dp))
            SizeSelector()
            ProductDetails()

        }
    }

    private @Composable
    fun ProductDetails() {
        Column() {
            ExpandableCard(
                ExpandableCardData(
                    title = "DETAILS", body = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum "
                ))
            ExpandableCard(
                ExpandableCardData(
                    title = "SIZE & FIT", body = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum "
                ))
            ExpandableCard(
                ExpandableCardData(
                    title = "COMPOSITION & CARE", body = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum "
                ))
            ExpandableCard(
                ExpandableCardData(
                    title = "DELIVERY & RETURNS", body = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum "
                ))
        }
    }

    private @Composable
    fun SizeSelector() {
        OutlinedButton(
            onClick = {  },
            border = BorderStroke(0.5.dp, Brand1),
            shape = RoundedCornerShape(16),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Brand5),
            modifier = Modifier.fillMaxWidth(),
        ){
            Box(
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Select your size",
                        fontSize = 16.sp,
                        style = TextStyle(
                            color = Brand1,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.down_arrow),
                    contentDescription = "Product description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(8.dp)
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }

    @Composable
    private fun finalSaleTag() {
        Text(text = "Final Sale",
            fontSize = 16.sp,
            style = TextStyle(
                color = Brand3
            ))
    }

    @Composable
    private fun DesignerName() {
        Text(text = "Valentino",
            fontSize = 16.sp,
            style = TextStyle(
                color = Brand1,
                fontWeight = FontWeight.Bold
            ))
    }

    @Composable
    private fun ProductDescription() {
        Text(text = "Print-sequined tshirt",
            fontSize = 16.sp,
            style = TextStyle(

                color = Brand1
            ))
    }

    @Composable
    private fun ProductValue() {
        Text(text = "$1,000",
            fontSize = 16.sp,
            style = TextStyle(
                color = Brand1
            ))
    }

    @Composable
    private fun ProductCarousel(scrollState: ScrollState) {
        Row(content = {
            Image(
                painter = painterResource(id = R.drawable.product_image),
                contentDescription = "Product description",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .absoluteOffset(y = -(scrollState.value * 0.1f).dp)
                    .alpha(min(1f, 1 - (scrollState.value / 600f)))

            )
        })
    }

    @Preview
    @Composable
    fun preview() {
        buildContent()
    }
}