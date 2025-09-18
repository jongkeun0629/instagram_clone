import { create } from "zustand";
import { authService } from "../services/auth";

const useAuthStore = create((set) => ({
  user: "",
  isAuthenticated: authService.isAuthenticated(),
  loading: false,
  error: null,

  login: async (userData) => {
    set({ loading: true, error: null });
    try {
      // 로그인 요청
      const data = await authService.login(userData);
      // 상태 변경
      set({
        user: data.user,
        isAuthenticated: true,
        loading: false,
      });
      return data;
    } catch (err) {
      set({
        loading: false,
        error: err.response?.data?.message || "Login failed",
      });
    }
  },

  register: async (userData) => {
    set({ loading: true, error: null });
    try {
      // 서버로부터 데이터 요청 & 응답
      const data = await authService.register(userData);
      // set에 반영
      set({
        user: data.user,
        isAuthenticated: true,
        loading: false,
      });
      return data;
    } catch (err) {
      set({
        loading: false,
        error: err.response?.data?.message || "Registration failed",
      });
      throw err;
    }
  },

  logout: () => {
    authService.logout();
    set({
      user: null,
      isAuthenticated: false,
      error: null,
    });
  },
}));

export default useAuthStore;
