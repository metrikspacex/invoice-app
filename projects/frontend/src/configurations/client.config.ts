import { provideHttpClient } from "@angular/common/http";
import type { ApplicationConfig } from "@angular/core";
import { provideAnimations } from "@angular/platform-browser/animations";
import {
  provideRouter,
  withEnabledBlockingInitialNavigation,
} from "@angular/router";

import routes from "../routes";

export const client_config: ApplicationConfig = {
  providers: [
    provideAnimations(),
    provideHttpClient(),
    provideRouter(routes, withEnabledBlockingInitialNavigation()),
  ],
};
