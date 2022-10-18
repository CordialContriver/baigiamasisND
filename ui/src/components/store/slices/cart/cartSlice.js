import {createSlice} from "@reduxjs/toolkit";
import {addToStorage, getFromStorage} from "../../../storage/localStorage";

const initialState = [];

const cartSlice = createSlice(
	{
		name: 'cart',
		initialState,
		reducers: {
			addToCart(state, {payload: item}) {
				const existInCart = state.find(p => p.id === item.id);
				if (existInCart) {
					existInCart.quantity++;
				}
				else {
					item.quantity = 1;
					state.push(item);
				}
			},
			removeFromCart(state, {payload: id}) {
				return state.filter(p => p.id !== id);
			},
			increaseProductQuantity(state, {payload: id}) {
				const item = state.find(p => p.id === id);
				if (item) {
					item.quantity++;
				}

			},
			decreaseProductQuantity(state, {payload: id}) {
				const item = state.find(p => p.id === id);
				if (item) {
					item.quantity--;
				}
			}
		}
	}
);

let cartState = [];
const subscribeToStore = (store) => {
	store.subscribe(() => {
		const cart = store.getState().cart;
		if (cartState !== cart) {
			addToStorage('cart', cart);
			cartState = cart;
		}
	});
};

const getItemsFromStorage = () => getFromStorage('cart') || [];

export default cartSlice.reducer;
export const {addToCart, removeFromCart, increaseProductQuantity, decreaseProductQuantity} = cartSlice.actions;
export {
	subscribeToStore,
	getItemsFromStorage
}
