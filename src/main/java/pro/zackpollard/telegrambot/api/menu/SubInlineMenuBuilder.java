package pro.zackpollard.telegrambot.api.menu;

/**
 * Menu builder for submenus. Instantiated by InlineMenuBuilder
 *
 * @author Mazen Kotb
 * @see InlineMenuBuilder#subMenu()
 */
public class SubInlineMenuBuilder extends AbstractInlineMenuBuilder<SubInlineMenuBuilder> {
    private InlineMenuBuilder builder;

    SubInlineMenuBuilder(InlineMenuBuilder builder) {
        this.builder = builder;
    }

    @Override
    protected SubInlineMenuBuilder instance() {
        return this;
    }

    @Override
    public InlineMenu buildMenu() {
        InlineMenu menu = buildMenu(null);

        builder.subs.add(menu);
        return menu;
    }
}
