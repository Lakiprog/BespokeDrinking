import { Navigate, Outlet } from "react-router-dom";
import * as authService from "./AuthService";

const ProtectedRoute = ({ roles }: any) => {
	let currentUserRole = authService.getRole();
	let accessToken = authService.getAccessToken();

	return roles.includes(currentUserRole) && accessToken ? (
		<Outlet />
	) : (
		<Navigate to="/" />
	);
};

export default ProtectedRoute;
