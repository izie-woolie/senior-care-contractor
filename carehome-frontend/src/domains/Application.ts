import type { ApplicationStatus } from "./ApplicationStatus";

export default interface Application {
  id: string | undefined;
  pitch: string;
  appliedAt: Date | undefined;
  applicationStatus: ApplicationStatus | undefined;
}
