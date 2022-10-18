import Header from "./components/header/Header";
import Content from "./components/content/Content";
import Footer from "./components/footer/Footer";
import {BrowserRouter} from "react-router-dom";
import {createContext, useState} from "react";
import {Provider} from "react-redux";
import {store} from "./components/store/store.js"

/*
const CartContext = createContext(null);
*/

function App() {

   /* const [cartItems, setCartItems] = useState([]);

    const cart = {
        cartItems,
        itemToCart: (item, quantity) => {
            const copyCartItems = [...cartItems];
            const existInCart = copyCartItems.find(i => i.id === i.id);
            if (existInCart) {
                existInCart.quantity+= quantity;
            }
            else {
                copyCartItems.push({...item, quantity: quantity});
            }
            setCartItems(copyCartItems);
        },
        removeFromCart: (item) =>{
            const id=item.id;
            const copyCartItems = cartItems.filter(i=> i.id !== id);
            setCartItems(copyCartItems);
        }
    };
*/


    return (
        <Provider store={store}>
        <BrowserRouter>
            <Header/>
            <Content/>
            <Footer/>
        </BrowserRouter>
        </Provider>
    )
}

export default App;