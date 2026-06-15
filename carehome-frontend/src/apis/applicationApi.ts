import axios from "axios";

// const json = { headers: { "Content-Type": "application/json" } };

const base = "/api/v1/applications";

export const applicationApi = {
  test: () => axios.get<string>(`${base}`),
};
