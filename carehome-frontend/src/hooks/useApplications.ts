import { useQuery } from "@tanstack/react-query";
import { applicationApi } from "../apis/applicationApi";

export const applicationKeys = {
  all: ["applications"] as const,
  detail: (id: string) => ["applications", id] as const,
};

export function useApplications() {
  return useQuery({
    queryKey: applicationKeys.all,
    queryFn: applicationApi.test,
  });
}
