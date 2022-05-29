import { Token } from "./Token";

export const getAccessToken = () => {
	return localStorage.getItem("accessToken");
};

export const getUsername = () => {
	return localStorage.getItem("username");
};

export const getRole = () => {
	return localStorage.getItem("role");
};

export const getId = () => {
	return localStorage.getItem("id");
};

export const removeToken = () => {
	localStorage.removeItem("accessToken");
	localStorage.removeItem("username");
	localStorage.removeItem("role");
};

export const storeToken = (token: Token) => {
	localStorage.setItem("accessToken", token.accessToken);
	localStorage.setItem("id", token.id.toString());
	localStorage.setItem("username", token.username);
	localStorage.setItem("role", token.role);
};
