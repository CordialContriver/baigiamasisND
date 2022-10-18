import cart, {getItemsFromStorage, subscribeToStore} from "./slices/cart/cartSlice";
import user from './slices/user/userSlice'
import {configureStore} from "@reduxjs/toolkit";

const buildStore = () => {
	const store = configureStore(
		{
			reducer: {
				cart, user
			},
			preloadedState: {
				cart: getItemsFromStorage()
			}
		}
	);

	subscribeToStore(store);

	return store;
}

const store = buildStore();

export default store;
