package com.bannia.reto01twitter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RetoTweet() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.Black)


    ) {

        Row(modifier = Modifier.padding(10.dp)) {

            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Logo Avatar",
                    modifier = Modifier
                        .width(60.dp)
                        .clip(CircleShape)

                )

            }
            Column(modifier = Modifier.padding(10.dp)) {

                HeaderTweet()


                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Linea larga del tweet nº0",
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Linea larga del tweet nº0",
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Linea larga del tweet nº0",
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Linea larga del tweet nº0",
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Logo Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(25.dp))
                )

                Spacer(modifier = Modifier.height(20.dp))
                TweeterFooter()

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(Modifier.fillMaxWidth(), Color.Gray, thickness = 2.dp)
    }
}

@Composable
fun HeaderTweet(){
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Juan Carlos",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(modifier = Modifier.padding(5.dp), text = "@jcglp", color = Color.Gray)
            Text(modifier = Modifier.padding(5.dp), text = "4h", color = Color.Gray)
        }


        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = null,
            tint = Color.White,

            )

    }
}
@Composable
fun TweeterFooter() {

    Row(
        Modifier
            .fillMaxWidth()
    ) {

        IconoAccion(
            icono = R.drawable.ic_chat,
            activateIcono = R.drawable.ic_chat_filled,
            activateColor = Color.White
        )

        Spacer(modifier = Modifier.width(25.dp))
        IconoAccion(
            icono = R.drawable.ic_rt,
            activateIcono = R.drawable.ic_rt,
            activateColor = Color.Green
        )

        Spacer(modifier = Modifier.width(25.dp))
        IconoAccion(
            icono = R.drawable.ic_like,
            activateIcono = R.drawable.ic_like_filled,
            activateColor = Color.Red
        )

    }


}

@Composable
fun IconoAccion(icono: Int, activateIcono: Int, activateColor: Color) {

    var incremento by rememberSaveable { mutableStateOf(1) }
    var contador by rememberSaveable { mutableStateOf(1) }
    Icon(
        painter = if (contador > 1) painterResource(id = activateIcono) else painterResource(id = icono),
        tint = if (contador > 1) activateColor else Color.Gray,
        contentDescription = "",
        modifier = Modifier
            .padding(start = 10.dp)
            .clickable {
                contador += incremento
                incremento = incremento * -1
            }

    )
    Text(text = "${contador}", color = Color.Gray, modifier = Modifier.padding(start = 5.dp))
}