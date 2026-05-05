# Heavy Throw - Beta 1.0

## 📖 Introduction

**Heavy Throw** is an expansion mod for Minecraft's Mace, adding a brand new enchantment "Heavy Throw".

When a player uses an enchanted mace, they can throw it out. The mace will **automatically track and attack all nearby mobs in sequence**. Damage increases with flight time, speed grows as it hits, and it returns automatically after eliminating all targets.

---

## 🎮 How to Use

1. **Hold the enchanted mace**
2. **Point toward mobs**
3. **Right-click**
4. The mace flies out and tracks targets automatically
5. Returns to inventory after killing all targets

---

## 🛠️ Enchantment Acquisition

| Method | Probability / Description |
|--------|---------------------------|
| Trial Chamber Vault | 0.1% chance to drop enchanted book |
| Command | `/enchant @p heavythrow:heavy_throw 1` |

> **Note**: Cannot be obtained via enchanting table, villager trading, or fishing in current version. Only available through vaults or commands.

---

## 📊 Damage Calculation Examples

| Flight Time | Damage Multiplier | Actual Damage |
|-------------|-------------------|----------------|
| 0 seconds | ×1.00 | 8.0 |
| 1 second | ×1.20 | 9.6 |
| 2 seconds | ×1.44 | 11.5 |
| 3 seconds | ×1.73 | 13.8 |
| 5 seconds | ×2.49 | 19.9 |

---

## 🔧 Technical Specifications

| Parameter | Value |
|-----------|-------|
| Search Range | 64×64×64 blocks (4 chunks) |
| Priority Order | Nearest to farthest |
| Initial Speed | 4.0 blocks/second |
| Speed Increment | +0.6 per hit |
| Max Speed | 10.0 blocks/second |
| Max Flight Time | 30 seconds |
| Damage Growth | ×1.2 per second (exponential) |

---

## 📦 Installation

### Manual Installation

1. Download `heavy-throw-1.0.0.jar`
2. Open `.minecraft/mods/` folder
3. Place the Jar file inside
4. Launch the game

### Using Mod Launcher

- **FCL (Fold Craft Launcher)**: Place the mod in `mods` folder
- **PojavLauncher**: Same as Fabric mod installation

---

## 🎮 In-game Commands

| Command | Effect |
|---------|--------|
| `/enchant @p heavythrow:heavy_throw 1` | Enchant held mace |
| `/give @p minecraft:enchanted_book[minecraft:stored_enchantments={levels:{"heavythrow:heavy_throw":1}}]` | Get enchanted book |

---

## 🎨 Custom Configuration

Config file location: `.minecraft/config/heavythrow.json` (future version support)

No configurable parameters in current version.

---

## ⚠️ Notes

- ⚠️ Projectile currently **invisible** (functionally complete - perceivable via sound effects and damage numbers)
- ⚠️ **Fabric API** latest version required
- ⚠️ Mod must be installed on both server and client
- ⚠️ Enchanted books can be obtained via commands for testing

---

## 📝 Version History

### Beta 1.0 (Current)

#### New Features
- ✅ Heavy Throw enchantment
- ✅ Auto-track all mobs
- ✅ Exponential damage growth (×1.2 per second)
- ✅ Speed increment mechanism
- ✅ Auto-return mechanic
- ✅ Player death protection (mace directly enters inventory)
- ✅ Sound feedback

#### Technical Implementation
- ✅ Custom entity `HeavyProjectile`
- ✅ Mixin intercepting mace right-click
- ✅ Server-side tracking logic
- ✅ Client-side empty renderer (prevents crash)

#### Known Limitations
- ⚠️ Projectile lacks model rendering
- ⚠️ Enchantment requires manual acquisition (via commands)

---

## 🐛 Known Issues

| Issue | Status | Planned Fix |
|-------|--------|--------------|
| Projectile invisible | Present | Beta 2.0 (add model) |
| Some mobs may be missed | Fixed | - |
| Occasional delay in mace return on death | Fixed | - |

---

## 🚀 Future Plans (Beta 2.0)

- [ ] Projectile model rendering (visible flying mace)
- [ ] Custom particle effects
- [ ] Config file support (adjustable speed, damage, range)
- [ ] More natural acquisition methods (fishing, villager trading)
- [ ] Multiple mace simultaneous throw support

---

## 📄 License

This project is licensed under the **MIT* License.

---

## 👤 Author

**Monkey**

- Mod ID: `heavy-throw`
- Namespace: `heavythrow`
- Enchantment ID: `heavythrow:heavy_throw`

---

## 🙏 Acknowledgements

Thanks to the Fabric community for providing the powerful modding framework.

Thanks to all testers for their feedback.

---

## 📞 Feedback & Support

If you have questions or suggestions, feel free to provide feedback through:

- GitHub Issues: (to be created)
- Modrinth Comments: (to be published)

---

## 📊 Mod Statistics

| Metric | Data |
|--------|------|
| Lines of Code | ~390 lines |
| Number of Files | 12 files |
| New Enchantments | 1 |
| New Entities | 1 |
| Development Time | ~3 days |

---

**May your mace never miss!** ⚡🔨

---

*Last updated: 2026-05-04*

------
# 沉重投掷 (Heavy Throw) - Beta 1.0

## 📖 简介

**沉重投掷** 是一个为 Minecraft 重锤设计的扩展模组，为原版重锤添加了全新的「沉重投掷」附魔。

当玩家使用附魔重锤时，可以将重锤投掷出去，它会**自动追踪并依次攻击周围所有生物**，伤害随飞行时间增长，速度越打越快，杀光所有目标后自动返回。

---

## 🎮 使用方式

1. **手持附魔重锤**
2. **对准生物群方向**
3. **右键点击**
4. 重锤自动飞出并追踪攻击
5. 击杀所有目标后自动返回背包

---

## 🛠️ 附魔获取途径

| 方式 | 概率/说明 |
|------|-----------|
| 试炼大厅宝库 | 0.1% 概率掉落附魔书|
| 命令 | `/enchant @p heavythrow:heavy_throw 1` |

> **注**：当前版本无法通过附魔台、村民交易或钓鱼获得，仅能通过宝库或命令获取。

---

## 📊 伤害计算示例

| 飞行时间 | 伤害倍率 | 实际伤害 |
|----------|----------|----------|
| 0 秒 | ×1.00 | 8.0 |
| 1 秒 | ×1.20 | 9.6 |
| 2 秒 | ×1.44 | 11.5 |
| 3 秒 | ×1.73 | 13.8 |
| 5 秒 | ×2.49 | 19.9 |

---

## 🔧 技术规格

| 项目 | 参数 |
|------|------|
| 搜索范围 | 64×64×64 格（4 个区块） |
| 优先顺序 | 距离由近到远 |
| 初始速度 | 4.0 格/秒 |
| 速度增量 | 每命中 +0.6 |
| 最大速度 | 10.0 格/秒 |
| 最大飞行时间 | 30 秒 |
| 伤害成长 | 每秒 ×1.2（指数） |

---

## 🔧 技术规格

| 项目 | 参数 |
|------|------|
| 搜索范围 | 64×64×64 格（4 个区块） |
| 优先顺序 | 距离由近到远 |
| 初始速度 | 4.0 格/秒 |
| 速度增量 | 每命中 +0.6 |
| 最大速度 | 10.0 格/秒 |
| 最大飞行时间 | 30 秒 |
| 伤害成长 | 每秒 ×1.2（指数） |

---

## 📦 安装方式

### 手动安装

1. 下载 `heavy-throw-1.0.0.jar`
2. 打开 `.minecraft/mods/` 文件夹
3. 将 Jar 文件放入
4. 启动游戏

### 使用 Mod 启动器

- **FCL（Fold Craft Launcher）**：将模组放入 `mods` 文件夹
- **PojavLauncher**：同 Fabric 模组安装方式

---

## 🎮 游戏内命令

| 命令 | 作用 |
|------|------|
| `/enchant @p heavythrow:heavy_throw 1` | 为手中重锤附魔 |
| `/give @p minecraft:enchanted_book[minecraft:stored_enchantments={levels:{"heavythrow:heavy_throw":1}}]` | 获取附魔书 |

---

## 🎨 自定义配置

配置文件位置：`.minecraft/config/heavythrow.json`（未来版本支持）

当前版本暂无可配置参数。

---

## ⚠️ 注意事项

- ⚠️ 投掷物当前版本**不可见**（功能完整，通过音效和伤害数字感知）
- ⚠️ 需要安装 **Fabric API** 最新版
- ⚠️ 服务端与客户端必须同时安装此模组
- ⚠️ 附魔书可通过命令获得，测试时可用

---

## 📝 版本历史

### Beta 1.0（当前版本）

#### 新增功能
- ✅ 沉重投掷附魔
- ✅ 自动追踪所有生物
- ✅ 伤害指数成长（每秒 ×1.2）
- ✅ 速度递增机制
- ✅ 自动返还重锤
- ✅ 玩家死亡保护（重锤直接进入背包）
- ✅ 音效反馈

#### 技术实现
- ✅ 自定义实体 `HeavyProjectile`
- ✅ Mixin 拦截重锤右键
- ✅ 服务端追踪逻辑
- ✅ 客户端空渲染器（防崩溃）

#### 已知限制
- ⚠️ 投掷物暂无模型渲染
- ⚠️ 需手动配置附魔（可通过命令获得）

---

## 🐛 已知问题

| 问题 | 状态 | 计划修复 |
|------|------|----------|
| 投掷物不可见 | 存在 | Beta 2.0（计划添加模型） |
| 部分生物可能被遗漏 | 已修复 | - |
| 死亡时重锤传送偶尔延迟 | 已修复 | - |

---

## 🚀 未来计划（Beta 2.0）

- [ ] 添加投掷物模型渲染（重锤飞行可见）
- [ ] 添加自定义粒子效果
- [ ] 支持配置文件（可调速度、伤害、范围）
- [ ] 添加附魔书自然获取途径（宝库/钓鱼）
- [ ] 支持多个重锤同时投掷

---

## 📄 开源协议

本项目采用 **MIT* 协议。

---

## 👤 作者

**Monkey**

- 模组 ID：`heavy-throw`
- 命名空间：`heavythrow`
- 附魔 ID：`heavythrow:heavy_throw`

---

## 🙏 致谢

感谢 Fabric 社区提供的强大模组框架。

感谢所有测试玩家提供的反馈。

---

## 📞 反馈与支持

如有问题或建议，欢迎通过以下方式反馈：

- GitHub Issues：（待创建）
- Modrinth 评论区：（待发布）

---

## 📊 模组统计

| 指标 | 数据 |
|------|------|
| 代码行数 | ~390 行 |
| 文件数量 | 12 个 |
| 新增附魔 | 1 个 |
| 新增实体 | 1 个 |
| 开发时长 | ~3 天 |

---

**愿你的重锤百发百中！** ⚡🔨

---

*最后更新：2026-05-04*
