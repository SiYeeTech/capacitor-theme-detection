import { WebPlugin } from '@capacitor/core';

import type { ThemeDetectionPlugin } from './definitions';

export class ThemeDetectionWeb
  extends WebPlugin
  implements ThemeDetectionPlugin
{
  isDarkModeActive(): Promise<{ active: boolean }> {
    throw new Error('Method not implemented.');
  }
}
