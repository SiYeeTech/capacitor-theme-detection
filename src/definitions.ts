import type { PluginListenerHandle } from '@capacitor/core';

export type ThemeMode = 'Dark' | 'Light';

export interface ThemeDetectionPlugin {
  isDarkModeActive(): Promise<{ active: boolean }>;

  addListener(
    eventName: 'themeModeChange',
    listenerFunc: (params: { mode: ThemeMode }) => void,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  removeAllListeners(): Promise<void>;
}
