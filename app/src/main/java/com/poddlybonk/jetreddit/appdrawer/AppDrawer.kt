package com.poddlybonk.jetreddit.appdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.poddlybonk.jetreddit.R
import com.poddlybonk.jetreddit.ui.theme.JetRedditThemeSettings

@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    closeDrawerAction: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
    ) {
        AppDrawerHeader()
        AppDrawerBody(closeDrawerAction)
        AppDrawerFooter(modifier)
    }
}

@Preview
@Composable
private fun AppDrawerHeader() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = Icons.Filled.AccountCircle,
            colorFilter = ColorFilter.tint(Color.LightGray),
            modifier = Modifier
                .padding(16.dp)
                .size(50.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            contentDescription = stringResource(id = R.string.account)
        )
        Text(
            text = stringResource(R.string.default_username),
            color = MaterialTheme.colors.primaryVariant
        )
        Divider(
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            )
        )
    }
}

@Composable
private fun ProfileInfo() {
    // TODO: Add your code here.
}

@Composable
private fun ProfileInfoItem(
    iconAsset: ImageVector,
    amountResourceId: Int,
    textResourceId: Int,
    modifier: Modifier
) {
    val colors = MaterialTheme.colors
    
    ConstraintLayout(modifier = Modifier) {
        val (iconRef, amountRef, titleRef) = createRefs()
        val itemModifier = Modifier
        
        Icon(
            contentDescription = stringResource(textResourceId),
            imageVector = iconAsset,
            tint = Color.Blue,
            modifier = itemModifier
                .constrainAs(iconRef) {
                    centerVerticallyTo(parent)
                    start.linkTo(parent.start)
                }
                .padding(start = 16.dp)
        )
        Text(
            text = stringResource(amountResourceId),
            color = colors.primaryVariant,
            fontSize = 10.sp,
            modifier = itemModifier
                .padding(start = 8.dp)
                .constrainAs(amountRef) {
                    top.linkTo(iconRef.top)
                    start.linkTo(iconRef.end)
                    bottom.linkTo(titleRef.top)
                }
        )
        Text(
            text = stringResource(textResourceId),
            color = Color.Gray,
            fontSize = 10.sp,
            modifier = itemModifier
                .padding(start = 8.dp)
                .constrainAs(titleRef) {
                    top.linkTo(amountRef.bottom)
                    start.linkTo(iconRef.end)
                    bottom.linkTo(iconRef.bottom)
                }
        )
    }
}

@Composable
private fun AppDrawerBody(closeDrawerAction: () -> Unit) {
    // TODO: Add your code here.
}

@Composable
private fun ScreenNavigationButton(
    icon: ImageVector,
    label: String,
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colors

    val surfaceModifier = modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
        .fillMaxWidth()

    Surface(
        modifier = surfaceModifier,
        color = colors.surface,
        shape = MaterialTheme.shapes.small
    ) {
        TextButton(
            onClick = onClickAction,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = icon,
                    colorFilter = ColorFilter.tint(Color.Gray),
                    contentDescription = label
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    fontSize = 10.sp,
                    text = label,
                    style = MaterialTheme.typography.body2,
                    color = colors.primaryVariant
                )
            }
        }
    }
}

@Composable
private fun AppDrawerFooter(modifier: Modifier = Modifier) {
    // TODO: Add your code here
}

private fun changeTheme() {
    JetRedditThemeSettings.isInDarkTheme.value = JetRedditThemeSettings.isInDarkTheme.value.not()
}

@Preview
@Composable
private fun ProfileInfoItemPreview() {
    ProfileInfoItem(
        Icons.Filled.ShoppingCart,
        R.string.default_reddit_age_amount,
        R.string.reddit_age,
        Modifier
    )
}
