import { WebPlugin } from '@capacitor/core';

import type { ThemeDetectionPlugin } from './definitions';

export class ThemeDetectionWeb
  extends WebPlugin
  implements ThemeDetectionPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
