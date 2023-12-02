import { registerPlugin } from '@capacitor/core';

import type { ThemeDetectionPlugin } from './definitions';

const ThemeDetection = registerPlugin<ThemeDetectionPlugin>('ThemeDetection', {
  web: () => import('./web').then(m => new m.ThemeDetectionWeb()),
});

export * from './definitions';
export { ThemeDetection };
