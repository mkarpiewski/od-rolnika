import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.routeLink
import styled.css
import styled.styledDiv
import styled.styledLi
import styled.styledUl

class TopBar : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        val linkButtonStyle: CSSBuilder.() -> Unit = {
            display = Display.block
            color = Color.black
            textAlign = TextAlign.center
            padding = "16px"
            textDecoration = TextDecoration.none
            hover {
                backgroundColor = Color.darkGrey
            }
        }

        styledUl {
            css {
                margin = "0"
                padding = "0"
                overflow = Overflow.hidden
                backgroundColor = Color.greenYellow
                put("list-style-type", "none")
            }
            styledLi {
                css {
                    float = Float.left
                }
                routeLink("/") {

                    styledDiv {
                        css(linkButtonStyle)
                        +"Strona główna"
                    }
                }
            }
            styledLi {
                css {
//                    display = Display.inline
                    float = Float.left
                }
                routeLink("/basket") {
                    styledDiv {
                        css(linkButtonStyle)
                        +"Koszyk"
                    }
                }
            }
        }
    }
}